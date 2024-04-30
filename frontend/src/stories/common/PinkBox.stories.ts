import type { Meta, StoryObj } from "@storybook/react";
import PinkBox from "../../components/common/PinkBox";

const meta = {
  title: "common/PinkBox",
  component: PinkBox,
  parameters: {
    layout: "centered",
  },
  args: {},
} satisfies Meta<typeof PinkBox>;

export default meta;
type Story = StoryObj<typeof meta>;

export const Default: Story = {
  args: {},
};
